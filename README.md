# graphqlcodegen-example

> **This repository is archived.** It is read-only and no longer maintained here.

## Why this repo was archived

The example project has been **vendored into the main [graphqlcodegen](https://github.com/deweyjose/graphqlcodegen) repository** as part of [PR #325](https://github.com/deweyjose/graphqlcodegen/pull/325) ([#324](https://github.com/deweyjose/graphqlcodegen/issues/324)).

Keeping examples in the same Maven reactor as the plugin gives us:

- **End-to-end validation** — example modules build against the plugin produced from the current commit, not a separately published version.
- **CI coverage** — the **E2E Example** workflow exercises schema files, jar-embedded schemas, remote URLs, introspection, type mappings, and client-API generation on every push.
- **One place to contribute** — plugin changes and example updates land in a single PR, with versions kept in sync.

The four modules (`common`, `server`, `client`, `client-introspection`) and their purpose are unchanged; only the location and build wiring moved.

## Where to find the examples

Clone the main repo and open:

**https://github.com/deweyjose/graphqlcodegen/tree/main/examples/graphqlcodegen-example**

Quick start from the repo root (uses the Maven wrapper):

```bash
git clone https://github.com/deweyjose/graphqlcodegen.git
cd graphqlcodegen
./mvnw -B -ntp install
```

That builds the plugin and all example modules. To run the demo interactively:

```
cd examples/graphqlcodegen-example/server && mvn spring-boot:run
# in another terminal:
cd examples/graphqlcodegen-example/client && mvn spring-boot:run
```

See the main repo’s [Testing with the example project](https://github.com/deweyjose/graphqlcodegen#testing-with-the-example-project) section for offline builds, CI details, and module layout.

## Where to contribute

| What you want to do | Where |
|---|---|
| Report a bug or request a plugin feature | [graphqlcodegen issues](https://github.com/deweyjose/graphqlcodegen/issues) |
| Add or update an example that showcases a plugin option | PR to [graphqlcodegen](https://github.com/deweyjose/graphqlcodegen) under `examples/graphqlcodegen-example/` |
| Plugin code, tests, or documentation | [graphqlcodegen](https://github.com/deweyjose/graphqlcodegen) |

Do **not** open new issues or PRs in this archived repo — they will not be reviewed.

## Historical note

This repo was the original standalone demo for [`io.github.deweyjose:graphqlcodegen-maven-plugin`](https://github.com/deweyjose/graphqlcodegen). Tags and commits here remain available for reference, but **main development continues only in [graphqlcodegen](https://github.com/deweyjose/graphqlcodegen).**
