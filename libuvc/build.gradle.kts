plugins {
	id("com.android.library")
	id("kotlin-android")
}

android {
	compileSdk = libs.versions.compileSdk.get().toInt()
	namespace = "com.jiangdg.uvccamera"
	ndkVersion = libs.versions.ndk.get()

	defaultConfig {
		minSdk = libs.versions.minSdk.get().toInt()
		targetSdk = libs.versions.targetSdk.get().toInt()
		ndk.abiFilters.addAll(listOf("armeabi-v7a","arm64-v8a")) // x86, x86_64 still in progress
	}

    compileOptions {
		sourceCompatibility(libs.versions.jvmTarget.get())
		targetCompatibility(libs.versions.jvmTarget.get())
	}

	buildTypes {
		release {
			isMinifyEnabled = false
			proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
		}
	}

//	externalNativeBuild {
//		ndkBuild {
//			path = File(projectDir, "./src/main/jni/Android.mk")
//		}
//	}

	externalNativeBuild {
		cmake {
			path = File(projectDir, "CMakeLists.txt")
		}
	}
}

dependencies {
	implementation(libs.androidx.appcompat)
	implementation(libs.timber)
}
