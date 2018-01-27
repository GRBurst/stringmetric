val commonSettings: Seq[Def.Setting[_]] = Seq(
    organization := "com.rockymadden.stringmetric",
    homepage := Some(url("https://rockymadden.com/stringmetric/")),
    scalaVersion := "2.12.4",
    scalacOptions ++= Seq("-unchecked", "-deprecation", "-encoding", "utf8", "-Xlint"),
    licenses := Seq("Apache 2.0" -> url("https://opensource.org/licenses/Apache-2.0")),
    developers := List(
        Developer(
            id = "rockymadden",
            name = "Rocky Madden",
            email = "github@rockymadden.com",
            url = url("https://rockymadden.com/")
        ),
        Developer(
            id = "ndelaforge",
            name = "Nicolas Delaforge",
            email = "nicolas.delaforge@mnemotix.com",
            url = url("https://www.mnemotix.com/")
        )
    ),
    // pomExtra :=
    //     <url>http://rockymadden.com/stringmetric/</url>
    //         <licenses>
    //             <license>
    //                 <name>MIT</name>
    //                 <distribution>repo</distribution>
    //             </license>
    //         </licenses>
    //         <scm>
    //             <url>git@github.com:rockymadden/stringmetric.git</url>
    //             <connection>scm:git:git@github.com:rockymadden/stringmetric.git</connection>
    //         </scm>
    //         <developers>
    //             <developer>
    //                 <id>rockymadden</id>
    //                 <name>Rocky Madden</name>
    //                 <url>http://rockymadden.com/</url>
    //             </developer>
    //         </developers>,
    // pomIncludeRepository := { _ => false },
    // publishMavenStyle := true,
    // publishArtifact := true,
    // publishTo := Some(
    //     if (isSnapshot.value)
    //         Opts.resolver.sonatypeSnapshots
    //     else
    //         Opts.resolver.sonatypeStaging
    // ),
    // updateOptions := updateOptions.value.withGigahorse(false)
)

lazy val root = Project("stringmetric", file("."))
	.settings(commonSettings)
	.settings(
		publishArtifact := false,
		version in ThisBuild := "0.28.0-SNAPSHOT"
	)
	.aggregate(core, cli)

lazy val core = Project("stringmetric-core", file("core"))
	.settings(commonSettings)
	.settings(
		libraryDependencies ++= Seq(
			"org.specs2" %% "specs2-core" % "4.0.2" % "test",
			"org.specs2" %% "specs2-junit" % "4.0.2" % Test
		)
	)

lazy val cli = Project("stringmetric-cli", file("cli"))
	.settings(commonSettings)
	.settings(
		libraryDependencies ++= Seq(
			"org.specs2" %% "specs2-core" % "4.0.2" % "test",
			"org.specs2" %% "specs2-junit" % "4.0.2" % Test
		)
	)
	.dependsOn(core)
