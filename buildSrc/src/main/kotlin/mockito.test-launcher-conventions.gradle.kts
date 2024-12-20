plugins {
    `jvm-toolchains`
}

tasks.withType<Test> {
    // Apply the CI test launcher configuration to any test tasks.
    javaLauncher = javaToolchains.launcherFor {
        languageVersion = providers
            .gradleProperty("mockito.test.java")
            .map {
                if (it == "auto") {
                    JavaLanguageVersion.of(JavaVersion.current().majorVersion)
                } else {
                    JavaLanguageVersion.of(it)
                }
            }
    }
}
