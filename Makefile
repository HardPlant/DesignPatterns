groupId=com.designpattern.mvc
artifactId=my-mvc
archetypeArtifactId="maven-archetype-quickstart"
interactiveMode="false"
module=App
version=1.0

init:
	mvn archetype:generate -DgroupId="$(groupId)" -DartifactId="$(artifactId)" -DarchetypeArtifactId=$(archetypeArtifactId) -DinteractiveMode=$(interactiveMode)

run:
	cd $(artifactId); java -cp target/$(artifactId)-$(version)-SNAPSHOT.jar $(groupId).$(module)

test: # compile code and package as jar
	mvn test -f $(artifactId)/pom.xml

package: # compile code and package as jar
	mvn package -f $(artifactId)/pom.xml

validate: # validat project and all nessasary information
	mvn validate -f $(artifactId)/pom.xml

compile:
	mvn compile -f $(artifactId)/pom.xml

install:
	mvn install -f $(artifactId)/pom.xml

dependency:
	mvn dependency:tree -f $(artifactId)/pom.xml

clean:
	rm rf $(artifactId)