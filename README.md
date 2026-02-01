# Flatpak Maven Example

This project serves as an example for [flatpak-maven-plugin](https://github.com/bithatch/maven-flatpak-plugin), a Maven Plugin that helps turning your Maven managed Java application into a application that can be distributed as a [Flatpak](https://flatpak.org/), e.g. from [Flathub](https://flathub.org/).

The application itself is a very simple JavaFX based web browser.

## Requirements

 * Modern Linux distribution with Flatpak support.
 * Java 25
 * Apache Maven (3.9.0+ recommended)
 * Flatpak builder.
 
## Layout

The project consists of just 3 files to create a runnable Flatpak application.

| File | Description |
| ---- | ----------- |
| pom.xml | The project object model. Plugin configuration here |
| src/flatpak/icons/icon.svg | The application icon |
| src/main/java | The Java application source with a single file with main method. |

## Build

```
mvn clean package
```

This will by default generate the Flatpak manifest and others in `target/app`. So from here you can build the package.

```
mvn install
```

## Run

Then run (or look in your application menu).

```
flatpak run uk.co.bithatch.FlatpakMavenExample 
```