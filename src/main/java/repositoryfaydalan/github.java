/*
Unutulmamasi gerekenler:
•	conflicleri localde hallet

git rm -r --cached .idea // gitignore dosyasi calismazsa workspacede hatalar gelebilir
			bu kod ile onbellek temizleniyor hatalar onleniyor
----------------------------------------------------------------------------------------------------------------
•	eger maine gecip pull yapmayi unutursam
	git stash save "bu sekilde araya kodlari kopyala"
	daha sonra main-pull-caner-merge
	git stash pop yaparak hem ara alandaki kodlari siler hem de guncellerle birlestirir

•	koda yazmadan cektim
•	git checkout main // maine gecmek icin
•	git pull // uzaktakini locale aliyorum
•	git checkout Caner // kendi yerine gec
•	git merge main // maindekileri caner kismina aliyorum.
•	burada kodlari yazdim
•	git add .
•	git commit -m "asd"
•	git checkout main // tekrar maine gectim
•	git pull // kodlari tekrar uzaktan locale aldim
•	git checkout caner // tekrar caner kismina geldim
•	git merge main // tekrar maindeki guncel kodlari canere aktardim
•	**burada conflict yasayabilirim** amac sikintiyi burada cozmek
•	git push
---------------------------------------------------------------------------------------------------------------------------**burada conflict yasayabilirim**
•	ayni alana kod yazilirsa cakisacak, silmeden de bos alanlara kodlari kaydirabilirim
•	herkesin calisma alanini onceden belirle ister bunu kod araligi ile istersen de class olarak belirlemek sart

*/