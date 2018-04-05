package kdx.backend.glfw

import kdx.*

open class GLFWWindowConfiguration
{
    var windowX = -1
    var windowY = -1
    var windowWidth = 640
    var windowHeight = 480

    var windowMinWidth = -1
    var windowMinHeight = -1
    var windowMaxWidth = -1
    var windowMaxHeight = -1

    var windowResizable = true
    var windowDecorated = true
    var windowMaximized = false

    var windowIconFileType: Files.FileType = Files.FileType.Local
	var windowIconPath: String = "icon.png"

    var windowListener: GLFWWindowListener? = null
    var fullscreenMode: GLFWDisplayMode? = null

    var title = ""
    var initialVisible = true

    internal fun setWindowConfiguration(config: GLFWWindowConfiguration)
    {
        windowX = config.windowX
        windowY = config.windowY
        windowWidth = config.windowWidth
        windowHeight = config.windowHeight
        windowMinWidth = config.windowMinWidth
        windowMinHeight = config.windowMinHeight
        windowMaxWidth = config.windowMaxWidth
        windowMaxHeight = config.windowMaxHeight
        windowResizable = config.windowResizable
        windowDecorated = config.windowDecorated
        windowMaximized = config.windowMaximized
        windowIconFileType = config.windowIconFileType
        windowIconPath = config.windowIconPath
        windowListener = config.windowListener
        fullscreenMode = config.fullscreenMode
        title = config.title
        initialVisible = config.initialVisible
    }
}