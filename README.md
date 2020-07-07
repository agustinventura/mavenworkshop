# mavenworkshop
SVQJUG Maven 101 Workshop Examples

This is a demo project intending to illustrate different stages of a project using Maven.

There's a total of nine commits:

1. In the very first commit there's simply the result of executing mvn archetype:generate
2. In the second one, we delete all superfluous information to show the minimum attributes that must be present in a pom.xml
3. Then we add a few properties to show how to use them (source encoding, compiler version...)
4. In this commit we add a really simple domain model consisting of a MediaPlayer and a Playlist.
5. As our example domain used System.out we add slf4j and log4j2 dependencies and configuration to show how can we add dependencies.
6. We have repeated the log4j version, so we add it to properties, showing how we can explicitly use one.
7. Our next goal is to add test dependencies: JUnit 5, AssertJ and Mockito.
8. Then we show how we can add plugins and configure the build process adding integration tests.
9. Lastly, we move integrations tests to a specific profile in order to only execute unit tests by default.

You can have a look at the slides here: https://docs.google.com/presentation/d/1TVuNQqqeqE5ZXGbs4aNjH-A9lPwwyikE9-7HnoMSYLo/edit?usp=sharing
