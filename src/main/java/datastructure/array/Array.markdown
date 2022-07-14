# 数组的思考

### 1.数组是对象吗？
数组在java中是一个对象，但是并不像普通的对象，他没有构造方法，没有任何方法，没有变量，甚至没有length这个成员变量

在java.lang.reflect.Array中，提供了许多操作数组的方法，可以看到许多的方法都是native，所以猜测数组应该是直接在jvm或者操作系统级别实现的



### 2.数组概述
数组在Java虚拟机中是个比较特殊的概念。为什么这么说呢，有下面几个原因：

1. 数组类和普通的类是不同的。普通的类从class文件中加载，但是数组类由Java虚拟机在运行时生成。数组的类名是左方括号([)+数组元素的类型描述符；数组类型描述符就是类名本身。例如int[]的类名是[I，int[][]的类名是[[I，Object[]的类名是[Ljava/lang/Object;，String[][]的类名是[[Ljava/lang/String;，等等。
2. 创建数组的方式和创建普通对象的方式不同。普通对象由new指令创建，然后由构造函数初始化。基本类型数组由newarray指令创建；引用类型数组由anewarray指令创建；另外还有一个专门的multianewarray指令用于创建多维数组。
3. 数组和普通对象存放的数据叶不同。普通对象中存放的是实例变量，通过putfield和各条field指令存取。数组对象中存放的则是数组元素，通过<t>aload和<t>astore系列指令按索引存取。其中<t>可以是a、b、c、d、f、i、l或者s。分别用于存取引用、byte、char、double、float、int、long或short类型的数组。


通过对
```aidl
int[] a = new int[20];
```
进行编译
我们发现创建数据是通过newarray这个字节码实现的
，后面了解到：
- newarray：用于创建基本类型的一维数组，其操作数为一字节，该字节用来表示对应的基本类型
- anewarray：用于创建引用类型的一维数组，其操作数为 2 字节，指向运行时常量池的一个类引用，该引用的类型就是引用类型数组中的元素类型
- multianewarray：用于创建多维数组，其操作数为 3 字节，前两个字节同 anewarray，后一个字节用来表示多维数组的纬度，由此也可以看出我们在 Java 中创建多维数组最大纬度为 255。


```aidl
//创建数据的JVM源码，以newarray为例
public class NEW_ARRAY extends Index8Instruction {
    //Array Type  atype
    private final int AT_BOOLEAN = 4;
    private final int AT_CHAR = 5;
    private final int AT_FLOAT = 6;
    private final int AT_DOUBLE = 7;
    private final int AT_BYTE = 8;
    private final int AT_SHORT = 9;
    private final int AT_INT = 10;
    private final int AT_LONG = 11;

    @Override
    public void execute(Zframe frame) {
        OperandStack operandStack = frame.getOperandStack();
        //从栈中获取数组的大小
        int count = operandStack.popInt();
        if (count < 0) {
            throw new NegativeArraySizeException("" + count);
        }
        ZclassLoader loader = frame.getMethod().getClazz().getLoader();
        Zclass arrClazz = getPrimitiveArrayClass(loader);
        Zobject arr = arrClazz.newArray(count);
        operandStack.pushRef(arr);
    }

    //获取基本类型数组的 class;如果没有加载过,需要加载进 JVM
    private Zclass getPrimitiveArrayClass(ZclassLoader loader) {
        //从字节码中获取到的 index 表明的是哪种类型的数组
        switch (this.index) {
            case AT_BOOLEAN:
                return loader.loadClass("[Z");
            case AT_BYTE:
                return loader.loadClass("[B");
            case AT_CHAR:
                return loader.loadClass("[C");
            case AT_SHORT:
                return loader.loadClass("[S");
            case AT_INT:
                return loader.loadClass("[I");
            case AT_LONG:
                return loader.loadClass("[J");
            case AT_FLOAT:
                return loader.loadClass("[F");
            case AT_DOUBLE:
                return loader.loadClass("[D");
            default:
                throw new RuntimeException("Invalid atype!");
        }
    }
}

```

anewarray  
创建引用类型的一维数组。其过程和创建基本类型的一维数组是类似的，只不过该数组的元素是引用类型，所以我们要先获取到数组元素的引用类型。由 anewarray 指令后的操作数获取，其操作数为 2 字节，指向运行时常量池的一个类引用，该引用的类型就是引用类型数组中的元素类型。我们在获取到该类引用之后，先将其转换为直接引用(若还为加载过该类，则需要先加载到方法区)。接下来根据类型名，创建其一维数组名，eg：数组元素为 String，那么其一维数组类型名就是：[java/lang/String；接下来创建引用类型的一维数组的过程就和创建基本类型的一维数组过程就一样了。


### 3.手写ArrayList
手写过程中，发现一些不同引发思考
在数组中，其实是可以间隔添加的，但是在ArrayList中，却不行
```aidl
//这种是可以的
int[] a = new int[10]
    a[0] = 0;
    a[5] = 5;

//这种会报错
ArrayList<String> arrayList = new ArrayList<>(10);
        arrayList.add(0,"a");
        arrayList.add(1,"b");
        arrayList.add(3,"a");
```
最终发现ArrayList的添加使用的算法,这个算法局限了只能在连续的数组上进行操作
```aidl
//从后往前遍历集合，找到对应位置，插入即可
        for(int i = size;i>index;i--) {
            //将元素统一往后面移动，上一个元素为i的值
            data[i] = data[i-1];
        }
```
