# BOUDO
# Ibrahim
# Université de Versailles Saint Quentin en Yveline
# 2016-2017

run: clean compil exec
	

exec:
	java -jar ./target/metroParisien-0.0.1-SNAPSHOT.jar metro.txt

compil:
	mvn package

clean:
	rm -rf target