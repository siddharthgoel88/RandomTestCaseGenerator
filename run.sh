if [ ! -d "bin" ]; then
	mkdir bin
fi
java -cp bin/:lib/stdlib-package.jar:. com.rgen.RandomTestGenerator

