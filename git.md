# **Git**  
## **走进Git**  
   <img src="https://image.itbaima.cn/markdown/2023/03/06/ZxY3MGkWRpOLVU6.jpg" alt="">  

## **基本命令**

### **创建本地仓库**
   * 创建本地仓库，再任意一个文件夹下打开`Git Bash`:  
   `git init`


   * 查看当前状态:  
   `git status`  
   <hr>  

### **添加与提交**
   * 添加文件到暂存区:  
   `git add test.txt`添加test.txt文件  
   `git add .`添加所有文件


   * 提交到本地仓库:  
   `git commit -m "test"`


   * 查看提交记录:
   `git log --oneline --graph --all`  
   <img src="https://s2.loli.net/2024/04/15/S6nQMNmoFr2g7tL.png">


   * 查看最近一次变更的详细内容:  
   `git show`  


   * 回滚  
   `git reset --hard commitID`  


   * 查看所有分支的操作记录:  
   `git reflog`  
   <img src="https://s2.loli.net/2024/04/15/LGWQi7Ez6dSmA4b.png">
   <hr>  

### **分支**  
我们可以在一个主干上分出N个分支，分别对多个分支的代码进行维护。


<hr>

#### **创建分支**


<hr>

#### **合并分支**

<hr>

#### **变基分支**  
* 合并是分支回到主干的过程，而变基是直接修改分支开始的位置，比如我们希望将`main`变基到`master`上，
那么`main`会将分支起点移动到`master`最后一次提交位置：  
   `git rebase master`  
* 变基后，main分支相当于同步了此前`master`分支的全部提交。

<hr>

***
#### **优选**

* 我们还可以选择其将他分支上的提交作用于当前分支上，这种操作称为`cherrypick`:  
   ``` 
   git cherry-pick <commit id>:  
   ```
* 单独合并一个提交 

<hr>



