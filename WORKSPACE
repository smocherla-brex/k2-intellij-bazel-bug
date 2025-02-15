load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

RULES_JVM_EXTERNAL_TAG = "5.0"

RULES_JVM_EXTERNAL_SHA = "8c3cd0ce6aa3dd8c01a414385e0a3807c7a14c769ca0aa3c53fb135c91f9198c"

http_archive(
    name = "rules_jvm_external",
    sha256 = RULES_JVM_EXTERNAL_SHA,
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    url = "https://github.com/bazelbuild/rules_jvm_external/releases/download/5.0/rules_jvm_external-%s.tar.gz" % RULES_JVM_EXTERNAL_TAG,
)

load("@rules_jvm_external//:repositories.bzl", "rules_jvm_external_deps")

rules_jvm_external_deps()

load("@rules_jvm_external//:setup.bzl", "rules_jvm_external_setup")

rules_jvm_external_setup()

http_archive(
    name = "rules_kotlin",
    sha256 = "d89723cc9ebbb7bdb2ebaca1af7d2383e074615643cf97a366b758a76b7dc443",
    url = "https://github.com/bazelbuild/rules_kotlin/releases/download/v2.0.0/rules_kotlin-v2.0.0.tar.gz",
)

load("@rules_kotlin//kotlin:repositories.bzl", "kotlin_repositories")

kotlin_repositories()  # if you want the default. Otherwise see custom kotlinc distribution below

load("@rules_kotlin//kotlin:core.bzl", "kt_register_toolchains")

register_toolchains("//:kotlin_toolchain")  # to use

load("@rules_jvm_external//:defs.bzl", "maven_install")

maven_install(
    name = "maven_micronaut4",
    artifacts = [
        "io.micronaut:micronaut-inject:4.3.0",
        "io.micronaut:micronaut-inject-kotlin:4.3.0",
        "jakarta.inject:jakarta.inject-api:2.0.0",
        "jakarta.validation:jakarta.validation-api:3.1.0",
        "io.micronaut:micronaut-runtime:4.3.0",
        "io.micronaut:micronaut-core:4.3.0",
        "io.micronaut:micronaut-context:4.3.0",
        "org.jetbrains.kotlin:kotlin-stdlib:2.0.0",
        "org.jetbrains.kotlin:kotlin-stdlib-jdk8:2.0.0",
        "org.jetbrains.kotlin:kotlin-stdlib-jdk7:2.0.0",
    ],
    maven_install_json = "@//:maven_micronaut4_install.json",
    repositories = [
        "https://maven.google.com",
        "https://repo1.maven.org/maven2",
        "https://packages.confluent.io/maven/",
        "https://jitpack.io",
        "https://repo.kotlin.link",
        "https://maven.pkg.jetbrains.space/mipt-npm/p/sci/maven",
        "https://mvnrepository.com/artifact/",
    ],
)

maven_install(
    name = "maven_micronaut3",
    artifacts = [
        "io.micronaut:micronaut-inject-java:3.10.2",
        "io.micronaut:micronaut-runtime:3.10.2",
        "io.micronaut:micronaut-validation:3.10.2",
        "javax.inject:javax.inject:1",
        "jakarta.inject:jakarta.inject-api:2.0.0",
        "jakarta.validation:jakarta.validation-api:3.1.0",
        "org.jetbrains.kotlin:kotlin-stdlib:2.0.0",
        "org.jetbrains.kotlin:kotlin-stdlib-jdk8:2.0.0",
        "org.jetbrains.kotlin:kotlin-stdlib-jdk7:2.0.0",
    ],
    maven_install_json = "@//:maven_micronaut3_install.json",
    repositories = [
        "https://maven.google.com",
        "https://repo1.maven.org/maven2",
        "https://packages.confluent.io/maven/",
        "https://jitpack.io",
        "https://repo.kotlin.link",
        "https://maven.pkg.jetbrains.space/mipt-npm/p/sci/maven",
        "https://mvnrepository.com/artifact/",
    ],
)

load("@maven_micronaut4//:defs.bzl", micronaut4 = "pinned_maven_install")

micronaut4()

load("@maven_micronaut3//:defs.bzl", micronaut3 = "pinned_maven_install")

micronaut3()
