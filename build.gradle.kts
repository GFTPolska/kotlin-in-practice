import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("jvm") version "1.3.71"
	kotlin("plugin.spring") version "1.3.71"
	id("org.springframework.boot") version "2.2.6.RELEASE"
	id("io.spring.dependency-management") version "1.0.9.RELEASE"
}

group = "com.gft.webinar"
version = "1.0"
java.sourceCompatibility = JavaVersion.VERSION_15

repositories {
	mavenCentral()
	jcenter()
}

dependencies {
	implementation(kotlin("stdlib-jdk8"))
	implementation(kotlin("reflect"))
	implementation("org.jetbrains.kotlinx:kotlinx-html-jvm:0.7.1")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.10.3")
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-web")
	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		// TODO: uncomment when talking about finding employees with too few badges
		freeCompilerArgs = listOf("-Xjsr305=strict", "-Xemit-jvm-type-annotations")
		jvmTarget = "13"
	}
}

tasks.withType<JavaCompile> {
	options.compilerArgs.add("--enable-preview")
}

tasks.getByName<org.springframework.boot.gradle.tasks.bundling.BootJar>("bootJar") {
	mainClassName = "com.gft.webinar.kip.Application"
}
