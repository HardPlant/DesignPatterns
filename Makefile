groupId="com.mycompany.app"
artifactId="my-app"
archetypeArtifactId="maven-archetype-quickstart"
interactiveMode="false"

init:
	mvn archetype:generate -DgroupId=$(groupId) -DartifactId=$(artifactId) -DarchetypeArtifactId=$(archetypeArtifactId) -DinteractiveMode=$(interactiveMode)