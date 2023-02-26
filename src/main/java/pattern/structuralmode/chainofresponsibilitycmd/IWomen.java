package pattern.structuralmode.chainofresponsibilitycmd;

/**
 * @author : chezj
 * @date : 2022/8/17 22:14
 */
public interface IWomen {

    //获得个人状况
    public int getType();

    //获得个人请示，你要干什么？出去逛街？约会?还是看电影？
    public String getRequest();

}
