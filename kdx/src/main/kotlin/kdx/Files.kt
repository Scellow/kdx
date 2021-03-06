package kdx

import kdx.files.FileHandle

enum class FileType
{
    Classpath,
    Internal,
    External,
    Absolute,
    Local
}

interface Files
{
    fun getFileHandle(path: String, type: FileType): FileHandle

    fun classpath(path: String): FileHandle

    fun internal(path: String): FileHandle

    fun external(path: String): FileHandle

    fun absolute(path: String): FileHandle

    fun local(path: String): FileHandle

    fun getExternalStoragePath(): String

    fun isExternalStorageAvailable(): Boolean

    fun getLocalStoragePath(): String

    fun isLocalStorageAvailable(): Boolean
}