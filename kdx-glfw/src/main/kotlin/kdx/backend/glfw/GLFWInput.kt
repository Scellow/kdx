package kdx.backend.glfw

import kdx.*


class GLFWInput(val window: GLFWWindow) : Input
{
    private var inputProcessor: InputProcessor? = null
    private val eventQueue = InputEventQueue()

    private var mouseX: Int = 0
    private var mouseY:Int = 0
    private var mousePressed: Int = 0
    private var deltaX: Int = 0
    private var deltaY:Int = 0
    private var justTouched: Boolean = false
    private var pressedKeys: Int = 0
    private var keyJustPressed: Boolean = false
    private val justPressedKeys = BooleanArray(256)
    private var lastCharacter: Char = ' '

    init
    {
        windowHandleChanged(window.getWindowHandle())
    }

    internal fun resetPollingStates()
    {
        justTouched = false
        keyJustPressed = false
        for (i in justPressedKeys.indices)
        {
            justPressedKeys[i] = false
        }
        eventQueue.setProcessor(null)
        eventQueue.drain()
    }

    fun windowHandleChanged(windowHandle: Long)
    {
        resetPollingStates()
        glfwSetKeyCallback(window.getWindowHandle(), keyCallback)
        glfwSetCharCallback(window.getWindowHandle(), charCallback)
        glfwSetScrollCallback(window.getWindowHandle(), scrollCallback)
        glfwSetCursorPosCallback(window.getWindowHandle(), cursorPosCallback)
        glfwSetMouseButtonCallback(window.getWindowHandle(), mouseButtonCallback)
    }

    internal fun update()
    {
        eventQueue.setProcessor(inputProcessor)
        eventQueue.drain()
    }

    internal fun prepareNext()
    {
        justTouched = false

        if (keyJustPressed)
        {
            keyJustPressed = false
            for (i in justPressedKeys.indices)
            {
                justPressedKeys[i] = false
            }
        }
        deltaX = 0
        deltaY = 0
    }


    override fun getAccelerometerX(): Float
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAccelerometerY(): Float
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAccelerometerZ(): Float
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getGyroscopeX(): Float
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getGyroscopeY(): Float
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getGyroscopeZ(): Float
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getX(): Int
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getX(pointer: Int): Int
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getDeltaX(): Int
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getDeltaX(pointer: Int): Int
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getY(): Int
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getY(pointer: Int): Int
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getDeltaY(): Int
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getDeltaY(pointer: Int): Int
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isTouched(): Boolean
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun justTouched(): Boolean
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isTouched(pointer: Int): Boolean
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isButtonPressed(button: Int): Boolean
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isKeyPressed(key: Int): Boolean
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isKeyJustPressed(key: Int): Boolean
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getTextInput(listener: Input.TextInputListener, title: String, text: String, hint: String)
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setOnscreenKeyboardVisible(visible: Boolean)
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun vibrate(milliseconds: Int)
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun vibrate(pattern: Array<Long>, repeat: Int)
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun cancelVibrate()
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAzimuth(): Float
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getPitch(): Float
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getRoll(): Float
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getRotationMatrix(matrix: Array<Float>)
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCurrentEventTime(): Long
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setCatchBackKey(catchBack: Boolean)
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isCatchBackKey(): Boolean
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setCatchMenuKey(catchMenu: Boolean)
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isCatchMenuKey(): Boolean
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setInputProcessor(processor: InputProcessor)
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getInputProcessor(): InputProcessor
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isPeripheralAvailable(peripheral: Input.Peripheral): Boolean
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getRotation(): Int
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getNativeOrientation(): Input.Orientation
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setCursorCatched(catched: Boolean)
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isCursorCatched(): Boolean
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setCursorPosition(x: Int, y: Int)
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}