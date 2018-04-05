package kdx.backend.glfw

public interface GLFWWindowListener {
	fun created(window: GLFWWindow)
	fun iconified(isIconified: Boolean)

	fun maximized(isMaximized: Boolean)
	fun focusLost()

	fun focusGained()

	fun closeRequested(): Boolean

	fun filesDropped(files: Array<String>)
	fun refreshRequested()
}
