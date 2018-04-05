package kdx.backend.glfw

import kdx.*
import kdx.files.*

class GLFWFiles : Files
{
    override val externalStoragePath: String
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val isExternalStorageAvailable: Boolean
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val localStoragePath: String
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val isLocalStorageAvailable: Boolean
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun getFileHandle(path: String, type: Files.FileType): FileHandle {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun classpath(path: String): FileHandle {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun internal(path: String): FileHandle {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun external(path: String): FileHandle {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun absolute(path: String): FileHandle {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun local(path: String): FileHandle {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}