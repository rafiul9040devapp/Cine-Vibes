#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_rafiul_baselib_NativeLib_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "https://api.themoviedb.org/3/";
    return env->NewStringUTF(hello.c_str());
}