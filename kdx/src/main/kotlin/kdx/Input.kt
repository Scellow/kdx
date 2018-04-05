package kdx

interface InputProcessor
{
    fun keyDown(keycode: Int): Boolean
    fun keyUp(keycode: Int): Boolean
    fun keyTyped(character: Char): Boolean
    fun touchDown(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean
    fun touchUp(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean
    fun touchDragged(screenX: Int, screenY: Int, pointer: Int): Boolean
    fun mouseMoved(screenX: Int, screenY: Int): Boolean
    fun scrolled(amount: Int): Boolean
}

interface Input
{
    interface TextInputListener
    {
        fun input(text: String)
        fun canceled()
    }

    object Buttons
    {
        val LEFT = 0
        val RIGHT = 1
        val MIDDLE = 2
        val BACK = 3
        val FORWARD = 4
    }

    object Keys
    {
        val ANY_KEY = -1
        val NUM_0 = 7
        val NUM_1 = 8
        val NUM_2 = 9
        val NUM_3 = 10
        val NUM_4 = 11
        val NUM_5 = 12
        val NUM_6 = 13
        val NUM_7 = 14
        val NUM_8 = 15
        val NUM_9 = 16
        val A = 29
        val ALT_LEFT = 57
        val ALT_RIGHT = 58
        val APOSTROPHE = 75
        val AT = 77
        val B = 30
        val BACK = 4
        val BACKSLASH = 73
        val C = 31
        val CALL = 5
        val CAMERA = 27
        val CLEAR = 28
        val COMMA = 55
        val D = 32
        val DEL = 67
        val BACKSPACE = 67
        val FORWARD_DEL = 112
        val DPAD_CENTER = 23
        val DPAD_DOWN = 20
        val DPAD_LEFT = 21
        val DPAD_RIGHT = 22
        val DPAD_UP = 19
        val CENTER = 23
        val DOWN = 20
        val LEFT = 21
        val RIGHT = 22
        val UP = 19
        val E = 33
        val ENDCALL = 6
        val ENTER = 66
        val ENVELOPE = 65
        val EQUALS = 70
        val EXPLORER = 64
        val F = 34
        val FOCUS = 80
        val G = 35
        val GRAVE = 68
        val H = 36
        val HEADSETHOOK = 79
        val HOME = 3
        val I = 37
        val J = 38
        val K = 39
        val L = 40
        val LEFT_BRACKET = 71
        val M = 41
        val MEDIA_FAST_FORWARD = 90
        val MEDIA_NEXT = 87
        val MEDIA_PLAY_PAUSE = 85
        val MEDIA_PREVIOUS = 88
        val MEDIA_REWIND = 89
        val MEDIA_STOP = 86
        val MENU = 82
        val MINUS = 69
        val MUTE = 91
        val N = 42
        val NOTIFICATION = 83
        val NUM = 78
        val O = 43
        val P = 44
        val PERIOD = 56
        val PLUS = 81
        val POUND = 18
        val POWER = 26
        val Q = 45
        val R = 46
        val RIGHT_BRACKET = 72
        val S = 47
        val SEARCH = 84
        val SEMICOLON = 74
        val SHIFT_LEFT = 59
        val SHIFT_RIGHT = 60
        val SLASH = 76
        val SOFT_LEFT = 1
        val SOFT_RIGHT = 2
        val SPACE = 62
        val STAR = 17
        val SYM = 63
        val T = 48
        val TAB = 61
        val U = 49
        val UNKNOWN = 0
        val V = 50
        val VOLUME_DOWN = 25
        val VOLUME_UP = 24
        val W = 51
        val X = 52
        val Y = 53
        val Z = 54
        val META_ALT_LEFT_ON = 16
        val META_ALT_ON = 2
        val META_ALT_RIGHT_ON = 32
        val META_SHIFT_LEFT_ON = 64
        val META_SHIFT_ON = 1
        val META_SHIFT_RIGHT_ON = 128
        val META_SYM_ON = 4
        val CONTROL_LEFT = 129
        val CONTROL_RIGHT = 130
        val ESCAPE = 131
        val END = 132
        val INSERT = 133
        val PAGE_UP = 92
        val PAGE_DOWN = 93
        val PICTSYMBOLS = 94
        val SWITCH_CHARSET = 95
        val BUTTON_CIRCLE = 255
        val BUTTON_A = 96
        val BUTTON_B = 97
        val BUTTON_C = 98
        val BUTTON_X = 99
        val BUTTON_Y = 100
        val BUTTON_Z = 101
        val BUTTON_L1 = 102
        val BUTTON_R1 = 103
        val BUTTON_L2 = 104
        val BUTTON_R2 = 105
        val BUTTON_THUMBL = 106
        val BUTTON_THUMBR = 107
        val BUTTON_START = 108
        val BUTTON_SELECT = 109
        val BUTTON_MODE = 110
        val NUMPAD_0 = 144
        val NUMPAD_1 = 145
        val NUMPAD_2 = 146
        val NUMPAD_3 = 147
        val NUMPAD_4 = 148
        val NUMPAD_5 = 149
        val NUMPAD_6 = 150
        val NUMPAD_7 = 151
        val NUMPAD_8 = 152
        val NUMPAD_9 = 153
        // public static final int BACKTICK = 0;
        // public static final int TILDE = 0;
        // public static final int UNDERSCORE = 0;
        // public static final int DOT = 0;
        // public static final int BREAK = 0;
        // public static final int PIPE = 0;
        // public static final int EXCLAMATION = 0;
        // public static final int QUESTIONMARK = 0;
        // ` | VK_BACKTICK
        // ~ | VK_TILDE
        // : | VK_COLON
        // _ | VK_UNDERSCORE
        // . | VK_DOT
        // (break) | VK_BREAK
        // | | VK_PIPE
        // ! | VK_EXCLAMATION
        // ? | VK_QUESTION
        val COLON = 243
        val F1 = 244
        val F2 = 245
        val F3 = 246
        val F4 = 247
        val F5 = 248
        val F6 = 249
        val F7 = 250
        val F8 = 251
        val F9 = 252
        val F10 = 253
        val F11 = 254
        val F12 = 255
        private val keyNames: MutableMap<String, Int> = mutableMapOf()
        fun toString(keycode: Int): String
        {
            if (keycode < 0) throw IllegalArgumentException("keycode cannot be negative, keycode: " + keycode)
            if (keycode > 255) throw IllegalArgumentException("keycode cannot be greater than 255, keycode: " + keycode)
            when (keycode)
            {
            // META* variables should not be used with this method.
                UNKNOWN -> return "Unknown"
                SOFT_LEFT -> return "Soft Left"
                SOFT_RIGHT -> return "Soft Right"
                HOME -> return "Home"
                BACK -> return "Back"
                CALL -> return "Call"
                ENDCALL -> return "End Call"
                NUM_0 -> return "0"
                NUM_1 -> return "1"
                NUM_2 -> return "2"
                NUM_3 -> return "3"
                NUM_4 -> return "4"
                NUM_5 -> return "5"
                NUM_6 -> return "6"
                NUM_7 -> return "7"
                NUM_8 -> return "8"
                NUM_9 -> return "9"
                STAR -> return "*"
                POUND -> return "#"
                UP -> return "Up"
                DOWN -> return "Down"
                LEFT -> return "Left"
                RIGHT -> return "Right"
                CENTER -> return "Center"
                VOLUME_UP -> return "Volume Up"
                VOLUME_DOWN -> return "Volume Down"
                POWER -> return "Power"
                CAMERA -> return "Camera"
                CLEAR -> return "Clear"
                A -> return "A"
                B -> return "B"
                C -> return "C"
                D -> return "D"
                E -> return "E"
                F -> return "F"
                G -> return "G"
                H -> return "H"
                I -> return "I"
                J -> return "J"
                K -> return "K"
                L -> return "L"
                M -> return "M"
                N -> return "N"
                O -> return "O"
                P -> return "P"
                Q -> return "Q"
                R -> return "R"
                S -> return "S"
                T -> return "T"
                U -> return "U"
                V -> return "V"
                W -> return "W"
                X -> return "X"
                Y -> return "Y"
                Z -> return "Z"
                COMMA -> return ","
                PERIOD -> return "."
                ALT_LEFT -> return "L-Alt"
                ALT_RIGHT -> return "R-Alt"
                SHIFT_LEFT -> return "L-Shift"
                SHIFT_RIGHT -> return "R-Shift"
                TAB -> return "Tab"
                SPACE -> return "Space"
                SYM -> return "SYM"
                EXPLORER -> return "Explorer"
                ENVELOPE -> return "Envelope"
                ENTER -> return "Enter"
                DEL -> return "Delete" // also BACKSPACE
                GRAVE -> return "`"
                MINUS -> return "-"
                EQUALS -> return "="
                LEFT_BRACKET -> return "["
                RIGHT_BRACKET -> return "]"
                BACKSLASH -> return "\\"
                SEMICOLON -> return ";"
                APOSTROPHE -> return "'"
                SLASH -> return "/"
                AT -> return "@"
                NUM -> return "Num"
                HEADSETHOOK -> return "Headset Hook"
                FOCUS -> return "Focus"
                PLUS -> return "Plus"
                MENU -> return "Menu"
                NOTIFICATION -> return "Notification"
                SEARCH -> return "Search"
                MEDIA_PLAY_PAUSE -> return "Play/Pause"
                MEDIA_STOP -> return "Stop Media"
                MEDIA_NEXT -> return "Next Media"
                MEDIA_PREVIOUS -> return "Prev Media"
                MEDIA_REWIND -> return "Rewind"
                MEDIA_FAST_FORWARD -> return "Fast Forward"
                MUTE -> return "Mute"
                PAGE_UP -> return "Page Up"
                PAGE_DOWN -> return "Page Down"
                PICTSYMBOLS -> return "PICTSYMBOLS"
                SWITCH_CHARSET -> return "SWITCH_CHARSET"
                BUTTON_A -> return "A Button"
                BUTTON_B -> return "B Button"
                BUTTON_C -> return "C Button"
                BUTTON_X -> return "X Button"
                BUTTON_Y -> return "Y Button"
                BUTTON_Z -> return "Z Button"
                BUTTON_L1 -> return "L1 Button"
                BUTTON_R1 -> return "R1 Button"
                BUTTON_L2 -> return "L2 Button"
                BUTTON_R2 -> return "R2 Button"
                BUTTON_THUMBL -> return "Left Thumb"
                BUTTON_THUMBR -> return "Right Thumb"
                BUTTON_START -> return "Start"
                BUTTON_SELECT -> return "Select"
                BUTTON_MODE -> return "Button Mode"
                FORWARD_DEL -> return "Forward Delete"
                CONTROL_LEFT -> return "L-Ctrl"
                CONTROL_RIGHT -> return "R-Ctrl"
                ESCAPE -> return "Escape"
                END -> return "End"
                INSERT -> return "Insert"
                NUMPAD_0 -> return "Numpad 0"
                NUMPAD_1 -> return "Numpad 1"
                NUMPAD_2 -> return "Numpad 2"
                NUMPAD_3 -> return "Numpad 3"
                NUMPAD_4 -> return "Numpad 4"
                NUMPAD_5 -> return "Numpad 5"
                NUMPAD_6 -> return "Numpad 6"
                NUMPAD_7 -> return "Numpad 7"
                NUMPAD_8 -> return "Numpad 8"
                NUMPAD_9 -> return "Numpad 9"
                COLON -> return ":"
                F1 -> return "F1"
                F2 -> return "F2"
                F3 -> return "F3"
                F4 -> return "F4"
                F5 -> return "F5"
                F6 -> return "F6"
                F7 -> return "F7"
                F8 -> return "F8"
                F9 -> return "F9"
                F10 -> return "F10"
                F11 -> return "F11"
                F12 -> return "F12"
            // BUTTON_CIRCLE unhandled, as it conflicts with the more likely to be pressed F12
                else ->
                    // key name not found
                    return "NotFound"
            }
        }

        fun valueOf(keyname: String): Int
        {
            return keyNames.get(keyname) ?: -1
        }

        private fun initializeKeyNames()
        {
            for (i in 0..255)
            {
                val name = toString(i)
                keyNames[name] = i
            }
        }
    }

    enum class Peripheral
    {
        HardwareKeyboard, OnscreenKeyboard, MultitouchScreen, Accelerometer, Compass, Vibrator, Gyroscope, RotationVector
    }

    enum class Orientation
    {
        Landscape, Portrait
    }

    fun getAccelerometerX(): Float
    fun getAccelerometerY(): Float
    fun getAccelerometerZ(): Float
    fun getGyroscopeX(): Float
    fun getGyroscopeY(): Float
    fun getGyroscopeZ(): Float

    fun getX(): Int
    fun getX(pointer: Int): Int
    fun getDeltaX(): Int
    fun getDeltaX(pointer: Int): Int
    fun getY(): Int
    fun getY(pointer: Int): Int
    fun getDeltaY(): Int
    fun getDeltaY(pointer: Int): Int
    fun isTouched(): Boolean
    fun justTouched(): Boolean
    fun isTouched(pointer: Int): Boolean
    fun isButtonPressed(button: Int): Boolean
    fun isKeyPressed(key: Int): Boolean
    fun isKeyJustPressed(key: Int): Boolean
    fun getTextInput(listener: TextInputListener, title: String, text: String, hint: String)
    fun setOnscreenKeyboardVisible(visible: Boolean)
    fun vibrate(milliseconds: Int)
    fun vibrate(pattern: Array<Long>, repeat: Int)
    fun cancelVibrate()
    fun getAzimuth(): Float
    fun getPitch(): Float
    fun getRoll(): Float
    fun getRotationMatrix(matrix: Array<Float>)
    fun getCurrentEventTime(): Long
    fun setCatchBackKey(catchBack: Boolean)
    fun isCatchBackKey(): Boolean
    fun setCatchMenuKey(catchMenu: Boolean)

    fun isCatchMenuKey(): Boolean
    fun setInputProcessor(processor: InputProcessor)
    fun getInputProcessor(): InputProcessor
    fun isPeripheralAvailable(peripheral: Peripheral): Boolean
    fun getRotation(): Int
    fun getNativeOrientation(): Orientation
    fun setCursorCatched(catched: Boolean)
    fun isCursorCatched(): Boolean
    fun setCursorPosition(x: Int, y: Int)
}