if [ ! -d "bin" ]; then
	mkdir bin
fi
javac -cp lib/stdlib-package.jar:. -d bin/  src/com/rgen/RandomTestGenerator.java
java -cp bin/:lib/stdlib-package.jar:. com.rgen.RandomTestGenerator

