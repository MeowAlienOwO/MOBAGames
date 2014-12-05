deploy:
	git checkout gh-source
	jekyll build
	git add -A
	git commit -m "update source"
	cp -r _site/ /tmp/
	git checkout gh-pages
	rm -r ./*
	cp -r /tmp/_site/* ./
	git add -A
	git commit -m "update page infor"
	echo "deploy finished"
	git push origin gh-pages
	git checkout gh-source
	git push origin gh-source
	echo "push finished"	
