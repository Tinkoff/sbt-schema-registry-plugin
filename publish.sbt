ThisBuild / versionScheme := Some("semver-spec")
ThisBuild / organization  := "ru.tinkoff"
ThisBuild / scmInfo       := Some(
  ScmInfo(
    url("https://github.com/Tinkoff/sbt-schema-registry-plugin"),
    "git@github.com:Tinkoff/sbt-schema-registry-plugin.git",
  ),
)

ThisBuild / developers    := List(
  Developer(
    id = "red-bashmak",
    name = "Vyacheslav Kalyokin",
    email = "v.kalyokin@tinkoff.ru",
    url = url("https://github.com/red-bashmak"),
  ),
)

ThisBuild / licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0"))
ThisBuild / description   := "Sbt plugin for download schemas from schema registry"
ThisBuild / homepage      := Some(url("https://github.com/Tinkoff/sbt-schema-registry-plugin"))
