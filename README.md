# Dark Skies

[![Build](https://img.shields.io/github/actions/workflow/status/sk1nx666/Dark-Skies/build.yml?branch=main&logo=github&label=build)](https://github.com/sk1nx666/Dark-Skies/actions/workflows/build.yml)
[![License: MIT](https://img.shields.io/github/license/sk1nx666/Dark-Skies)](LICENSE)
[![Modrinth](https://img.shields.io/modrinth/dt/dark-skies?label=modrinth&logo=modrinth)](https://modrinth.com/mod/dark-skies)

Fabric **client-only** mod for Minecraft **1.21.11** that makes the overworld sky uniformly dark (including the horizon band), similar to deep night.

## Downloads

- **[Modrinth](https://modrinth.com/mod/dark-skies)** — recommended for players (create the project with slug `dark-skies` or change links and `modrinth_slug` in `gradle.properties`).
- **[GitHub Releases](https://github.com/sk1nx666/Dark-Skies/releases)** — attach **`dark-skies-<version>.jar`** from `build/libs/` (not the `-sources` jar).

## Requirements

- **Java 21** or newer
- [Fabric Loader](https://fabricmc.net/) **0.18.6** or newer

## Installing

1. Install [Fabric Loader](https://fabricmc.net/use/installer/) for Minecraft **1.21.11**.
2. Put `dark-skies-*.jar` from Modrinth or Releases into `.minecraft/mods` (main artifact only, not `-sources.jar`).

## Building from source

Windows:

```bat
gradlew.bat build
```

macOS / Linux:

```sh
chmod +x gradlew
./gradlew build
```

Remapped jar: `build/libs/dark-skies-<version>.jar`.

## Maintainer notes

| Task | Where |
|------|--------|
| Fabric `fabric.mod.json` contact links (`homepage`, `sources`, `issues`) | `gradle.properties`: `modrinth_slug`, `github_repo` |
| GitHub Actions CI | [.github/workflows/build.yml](.github/workflows/build.yml) |
| Release artifact | Upload the remapped **`dark-skies-<version>.jar`** from `build/libs/` (omit `*-sources.jar`) |

Suggested **Modrinth** settings when creating the project: name **Dark Skies**, slug **dark-skies**, loader **Fabric**, Minecraft **1.21.11**, side **Client**, license **MIT**, source link to [this GitHub repo](https://github.com/sk1nx666/Dark-Skies).

## Dev client / run folder

Loom run tasks may create `run/`; it is gitignored.

## License

MIT — see [LICENSE](LICENSE).
