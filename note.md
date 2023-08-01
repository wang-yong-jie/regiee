# Git

## 本地仓库与远程仓库关联?

1. 在远程仓库（例如GitHub、GitLab等）上创建一个空的仓库，获取远程仓库的URL地址。

2. 在本地的git仓库目录下使用以下命令将本地仓库关联到远程仓库：

   ```
   git remote add origin 远程仓库的URL地址
   ```

3. 可以使用以下命令验证是否成功关联：

   ```
   git remote -v
   ```

4. 最后，使用以下命令将本地代码推送到远程仓库：

   ```
   git push -u origin master
   ```

## 如何删除远程分支？

```
git branch -r
git push origin --delete master
```

