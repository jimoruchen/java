## **变基分支**  
1. 除了直接合并分支以外，我们还可以进行变基操作，它跟合并不同，   
    * 合并是分支回到主干的过程，而变基是直接修改分支开始的位置，比如我们希望将`main`变基到`master`上，
那么`main`会将分支起点移动到`master`最后一次提交位置：  
   `git rebase master`
2. 变基后，main分支相当于同步了此前`master`分支的全部提交。
* [x] 即墨如尘
* [ ] 时间瞳
***
## **优选**

1. 我们还可以选择其将他分支上的提交作用于当前分支上，这种操作称为`cherrypick`:  
```
git cherry-pick <commit id>:  
```  
单独合并一个提交 
```java
public class leetcode01 {
    public static void main(String[] args) {
        System.out.println("hello world!");
    }
}
```
> 这里我们在master分支上创建一个新的文件：
> * 提交此次更新，  
> * 接着通过`cherry-pick`的方式将此次更新作用于test分支上。
