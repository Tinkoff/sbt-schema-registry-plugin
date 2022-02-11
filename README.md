# SBT Schema Registry Plugin

Sbt plugin for download schemas from schema registry. This plugin adds a new task `schemaRegistryDownload` for 
downloading schemas and some configuration parameters to declare schemas and schema registry endpoint

## Usage

To activate the plugin, you need to add the following lines to your `project/plugins.sbt` file:
```sbt
resolvers ++= Seq(
  // this resolver needed for load plugin dependencies
  "Confluent" at "https://packages.confluent.io/maven/",
)

addSbtPlugin("ru.tinkoff" % "sbt-schema-registry-plugin" % "<plugin-version>")
```
And next you need added this configuration in `build.sbt`
```sbt
import ru.tinkoff.load.avro.RegistrySubject

val schemas = Seq(
  RegistrySubject("hello.world.schema", 2),
  RegistrySubject("schema1-name", 12), 
  RegistrySubject("<schema-name>", <schema-version>),
)

val someProject = (project in file("."))
  .settings(
    ...,
    schemaRegistrySubjects ++= schemas,
    schemaRegistryUrl := "http://<schema-registry-host>:<schema-registry-port>", 
    ...
)
```
Then you can download schemes listed in `schemaRegistrySubjects` from schema registry by url from `schemaRegistryUrl`
with help a task `schemaRegistryDownload`

```bash
sbt schemaRegistryDownload
```

## Settings

To configure the plugin to interact with the schema registry the following parameters are used

| Parameter                  | Description                             | Default value          |
|----------------------------|-----------------------------------------|------------------------|
| schemaRegistrySubjects     | list schema subjects name with version  | `Seq()`                |
| schemaRegistryUrl          | url of schema registry                  | `http://locahost:8081` |
| schemaRegistryTargetFolder | Output directory for dowloading schemas | `./src/main/avro`      |