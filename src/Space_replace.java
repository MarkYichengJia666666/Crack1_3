
/**
 * Created by jiayicheng on 17/6/15.
 */
public class Space_replace {
    public static void main(String[] args)
    {//目的：替换一个字符串，把所有的空格键换成"％20"
        //假设：字符串有足够的空间加上这些字符，给你这个字符串的真实长度
        //分析：无论如何空格键都要捋一遍，所以一定是N

        String str="Mr John Smith     ";        //题设交代字符串真实有多长，如果后面还有东西就截掉
        int n=13;
        replaceSpaces(str,n);
    }

 static void replaceSpaces(String str, int truelength)
{   char[] str1 =str.toCharArray();
    int spacecount=0,index=0;
    for(int i=0; i<truelength;i++)    //数一下一共在真实长度范围内到底有几个空格存在
    {
        if(str1[i]==' ')
            spacecount++;
    }
    index=spacecount*2+truelength;   //这个长度即为新字符串的长度
    if(truelength<str.length())
        str1[truelength]='\0';       //截掉真实长度后面的字符
    for(int i=truelength-1;i>=0;i--)
    {
        if(str1[i]==' ') {
            str1[index-1] = '0';     //开始替换形成新的字符串，注意长度和指数的区别！
            str1[index-2]='2';
            str1[index-3]='%';
            index=index-3;           //开始下一轮
        }
        else
        {
           str1[index-1]=str1[i];    //没有空格就过去
            index--;
        }
    }                                //注意"替换"和"挪"的方法！！！
    System.out.print(str1);          //这个问题需要我们进去字符串中间的插入操作，而且是一换三，必然引起字符串的移动
}                                    //如果从左向右，那么需要移动后面的每一个尚未观察到的字符，硬插入
                                     //如果从右向左，那么可以从将字符串"抻开"的角度看问题，不涉及到未观察字符的移动！！！！！

    }

