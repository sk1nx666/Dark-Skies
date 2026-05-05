# Skies Remastered

Fabric **client-only** mod for Minecraft **1.21.11** that makes the overworld sky uniformly dark (including the horizon band), similar to deep night.

## Requirements

- **Java 21** or newer
- [Fabric Loader](https://fabricmc.net/) **0.18.6** or newer

## Build

Windows:

```bat
gradlew.bat build
```

macOS / Linux:

```sh
./gradlew build
```

The mod JAR is written to `build/libs/` (file name follows `archives_base_name` + version in `gradle.properties`).

## Run folder / dev client

If you use Loom’s run tasks, Fabric Loom may create a `run/` directory. It is ignored by Git.

## License

MIT — see [LICENSE](LICENSE).
