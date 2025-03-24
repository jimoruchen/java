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
   `git add DS.txt`添加test.txt文件  
   `git add .`添加所有文件


   * 提交到本地仓库:  
   `git commit -m "DS"`


   * 查看提交记录:  
   `git log --oneline --graph --all`  
   <img src="https://s2.loli.net/2024/04/15/S6nQMNmoFr2g7tL.png" alt="1.png">


   * 查看最近一次变更的详细内容:  
   `git show`  


   * 回滚  
   `git reset --hard commitID`  


   * 查看所有分支的操作记录:  
   `git reflog`  
   <img src="https://s2.loli.net/2024/04/15/LGWQi7Ez6dSmA4b.png" alt="2.png">
   <hr>  

### **分支**  
我们可以在一个主干上分出N个分支，分别对多个分支的代码进行维护。


<hr>

#### **创建分支**
   * 查看当前仓库中存在的分支:  
   `git branch`  


   * 创建新分支:  
   `git branch DS`  
   * 删除分支:  
   `git branch -d DS`


   * 添加文件后直接提交到到本地仓库:   
   `git commit -a -m "333"`  
   <img src="https://s2.loli.net/2024/04/15/yB7DxhuTFokSjcE.png" alt="3.png">

     
<hr>

#### **切换分支**
   * 切换分支:  
   `git checkout DS`  
   ![4.png](https://s2.loli.net/2024/04/15/cgI9XDLwiHkFrsf.png)

<hr>  

#### **合并分支**  
   * 先切换为master分支:  
   `git checkout master`   


   * 合并分支:  
   `git merge DS`  


   * 发生冲突后：手动修改后再提交。  
   ![5.png](https://s2.loli.net/2024/04/15/LAO5o4c7MgEUmpJ.png)

   
   * 未发生冲突：界面被锁定，先按Esc,再输入:wq(强制性写入文件并退出)。  
   ![6.png](https://s2.loli.net/2024/04/15/SGM3eyhuzN7c2rX.png)
   ![7.png](https://s2.loli.net/2024/04/15/upnByIUGNkPbztl.png)

<hr>

#### **变基分支**  
   * 变基：变基是直接修改分支开始的位置，比如我们希望将test变基到master上，
   那么test会将分支起点移动到master最后一次提交位置。
   `git rebase master`  
   ![8.png](https://s2.loli.net/2024/04/15/aykwD4YdGKQH8RC.png)  
   * 变基后，test分支相当于同步了此前master分支的全部提交。  

<hr>  

#### **优选**
   * 我们还可以选择其将他分支上的提交作用于当前分支上，这种操作称为`cherrypick`:  
   `git cherry-pick commitID`  
   ![9.png](https://s2.loli.net/2024/04/15/iMnPNat7Jgy9udZ.png)
   * 将master分支的提交作用于test上。
<hr> 


### **远程仓库**  

<hr>  

#### **推送**
   `git remote add 名称 远程仓库地址`  

   `git push 远程仓库名称 本地分支名称[:远端分支名称]`

<hr>  

#### **克隆**
   `git clone 远程仓库地址`

<hr>  

#### **抓取、拉取和冲突解决**
   `git fetch 远程仓库`  

   `git pull 远程仓库`