# This is a configuration file for ProGuard.
# http://proguard.sourceforge.net/index.html#manual/usage.html

-dontobfuscate
-dontoptimize
-dontpreverify

# Keep line numbers for crash reports
-keepattributes SourceFile,LineNumberTable

# Keep all of our app code
-keep class com.samsung.sensorapp.** { *; }

# Keep Android support library classes
-keep class androidx.** { *; }

# Keep native methods
-keepclasseswithmembernames class * {
    native <methods>;
}

# Keep custom application classes
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider

# Keep classes with public constructors
-keepclasseswithmembers public class * {
    public <init>(...);
}

# Keep enums
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

# Keep Parcelable implementations
-keep class * implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator *;
}

# Keep R classes
-keepclassmembers class **.R$* {
    public static <fields>;
}

# Preserve line numbers for error reporting
-renamesourcefileattribute SourceFile
