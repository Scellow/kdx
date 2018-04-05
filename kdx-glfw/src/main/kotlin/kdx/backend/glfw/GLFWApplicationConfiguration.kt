package kdx.backend.glfw

class GLFWApplicationConfiguration : GLFWWindowConfiguration()
{
    enum class HdpiMode
    {
        Logical,
        Pixels
    }
    companion object
    {
        internal fun copy(config: GLFWApplicationConfiguration): GLFWApplicationConfiguration
        {
            val copy = GLFWApplicationConfiguration()
            copy.set(config)
            return copy
        }
    }
    var disableAudio = false
    var audioDeviceSimultaneousSources = 16
    var audioDeviceBufferSize = 512
    var audioDeviceBufferCount = 9

    var useGL30 = false
    var gles30ContextMajorVersion = 3
    var gles30ContextMinorVersion = 2

    var r = 8
    var g = 8
    var b = 8
    var a = 8
    var depth = 16
    var stencil = 0
    var samples = 0

    var vSyncEnabled = true
    var idleFPS = 60

    var preferencesDirectory = ".prefs/"
    var preferencesFileType = FileType.External

    var hdpiMode = HdpiMode.Logical

    var debug = false

    fun set(config:GLFWApplicationConfiguration) {
        super.setWindowConfiguration(config)
        disableAudio = config.disableAudio
        audioDeviceSimultaneousSources = config.audioDeviceSimultaneousSources
        audioDeviceBufferSize = config.audioDeviceBufferSize
        audioDeviceBufferCount = config.audioDeviceBufferCount
        useGL30 = config.useGL30
        gles30ContextMajorVersion = config.gles30ContextMajorVersion
        gles30ContextMinorVersion = config.gles30ContextMinorVersion
        r = config.r
        g = config.g
        b = config.b
        a = config.a
        depth = config.depth
        stencil = config.stencil
        samples = config.samples
        vSyncEnabled = config.vSyncEnabled
        preferencesDirectory = config.preferencesDirectory
        preferencesFileType = config.preferencesFileType
        hdpiMode = config.hdpiMode
        debug = config.debug
    }

}