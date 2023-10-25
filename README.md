# Mica Utils for Java 8+ (micautils_j8)

A utility library for Java 8, provided by Mica Technologies.

## Modules

- **micautils**: [Main module containing Mica Utils for Java 8+]
- **micautils_manifold**: [Secondary module containing Mica Utils for Java 8+ with Manifold support]

## Getting Started

Most users will only need the main module, `micautils`. However, if you wish to use the
module with Manifold support, you will need to use the `micautils_manifold` module.

### Prerequisites

- Java 8 or higher

### Installation

To include `micautils` modules in your Maven project, first add the following repository to
your `pom.xml` file:

```xml

<repositories>
  <repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
  </repository>
</repositories>
```

#### Main Module: micautils

To use the main utility module, add the following dependency:

```xml

<dependency>
  <groupId>com.github.Mica-Technologies.micautils_j8</groupId>
  <artifactId>micautils</artifactId>
  <version>$TagVersion$</version>
</dependency>
```

Replace `$TagVersion$` with the desired version tag, e.g., `v1.0.0` or `v1.0.0-pre1`.

#### Manifold Module: micautils_manifold

If you wish to use the module with Manifold support, add this dependency:

```xml

<dependency>
  <groupId>com.github.Mica-Technologies.micautils_j8</groupId>
  <artifactId>micautils_manifold</artifactId>
  <version>$TagVersion$</version>
</dependency>
```

Replace `$TagVersion$` with the desired version tag, e.g., `v1.0.0` or `v1.0.0-pre1`.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

### JitPack

Thanks to JitPack for providing a platform to easily distribute this library.

[<img src="https://jitpack.io/w/img/jitpack_bg_opacity01.png" width="150" alt="JitPack" />](https://jitpack.io/)

### IntelliJ/JetBrains

A special shoutout to IntelliJ/JetBrains for providing open-source licensing for their products,
enhancing the development experience of this project.

[<img src="https://resources.jetbrains.com/storage/products/company/brand/logos/jb_beam.png" width="150" alt="IntelliJ/JetBrains" />](https://www.jetbrains.com/)
