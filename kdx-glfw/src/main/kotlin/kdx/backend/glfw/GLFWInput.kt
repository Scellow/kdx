package kdx.backend.glfw

import kdx.*

class GLFWInput(val window: GLFWWindow) : Input
{
    init
    {
        windowHandleChanged(window.windowHandle)
    }

    override val accelerometerX: Float
        get() = TODO("not implemented") 
    override val accelerometerY: Float
        get() = TODO("not implemented") 
    override val accelerometerZ: Float
        get() = TODO("not implemented") 
    override val gyroscopeX: Float
        get() = TODO("not implemented") 
    override val gyroscopeY: Float
        get() = TODO("not implemented") 
    override val gyroscopeZ: Float
        get() = TODO("not implemented") 
    override val x: Int
        get() = TODO("not implemented") 
    override val deltaX: Int
        get() = TODO("not implemented") 
    override val y: Int
        get() = TODO("not implemented") 
    override val deltaY: Int
        get() = TODO("not implemented") 
    override val isTouched: Boolean
        get() = TODO("not implemented") 
    override val azimuth: Float
        get() = TODO("not implemented") 
    override val pitch: Float
        get() = TODO("not implemented") 
    override val roll: Float
        get() = TODO("not implemented") 
    override val currentEventTime: Long
        get() = TODO("not implemented") 
    override var isCatchBackKey: Boolean
        get() = TODO("not implemented") 
        set(value) {}
    override var isCatchMenuKey: Boolean
        get() = TODO("not implemented") 
        set(value) {}
    override var inputProcessor: InputProcessor
        get() = TODO("not implemented") 
        set(value) {}
    override val rotation: Int
        get() = TODO("not implemented") 
    override val nativeOrientation: Input.Orientation
        get() = TODO("not implemented") 
    override var isCursorCatched: Boolean
        get() = TODO("not implemented") 
        set(value) {}

    override fun getX(pointer: Int): Int {
        TODO("not implemented")
    }

    override fun getDeltaX(pointer: Int): Int {
        TODO("not implemented")
    }

    override fun getY(pointer: Int): Int {
        TODO("not implemented")
    }

    override fun getDeltaY(pointer: Int): Int {
        TODO("not implemented")
    }

    override fun justTouched(): Boolean {
        TODO("not implemented")
    }

    override fun isTouched(pointer: Int): Boolean {
        TODO("not implemented")
    }

    override fun isButtonPressed(button: Int): Boolean {
        TODO("not implemented")
    }

    override fun isKeyPressed(key: Int): Boolean {
        TODO("not implemented")
    }

    override fun isKeyJustPressed(key: Int): Boolean {
        TODO("not implemented")
    }

    override fun getTextInput(listener: Input.TextInputListener, title: String, text: String, hint: String) {
        TODO("not implemented")
    }

    override fun setOnscreenKeyboardVisible(visible: Boolean) {
        TODO("not implemented")
    }

    override fun vibrate(milliseconds: Int) {
        TODO("not implemented")
    }

    override fun vibrate(pattern: LongArray, repeat: Int) {
        TODO("not implemented")
    }

    override fun cancelVibrate() {
        TODO("not implemented")
    }

    override fun getRotationMatrix(matrix: FloatArray) {
        TODO("not implemented")
    }

    override fun isPeripheralAvailable(peripheral: Input.Peripheral): Boolean {
        TODO("not implemented")
    }

    override fun setCursorPosition(x: Int, y: Int) {
        TODO("not implemented")
    }

}