import kotlinx.cinterop.*
import libglew.*
import libglfw.*
import kdx.graphics.Color

fun main(args: Array<String>)
{
    val color = Color(1f, 0f, 0f, 0f)
    println("Color: $color")

    println(Platform.type)

    if (glfwInit() == GLFW_FALSE)
        println("Init failed!")
    else
        println("Init good")

    glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3)
    glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3)

    val window = glfwCreateWindow(640, 480, "KT GL", null, null);
    if(window == null)
    {
        println("Unable to create the window")
        return
    }


    glfwMakeContextCurrent(window)
    glfwSwapInterval(1)


    testTextures()
    while (glfwWindowShouldClose(window) == GLFW_FALSE)
    {
        glClear(GL_COLOR_BUFFER_BIT)

        // draw stuff here

        glfwSwapBuffers(window)
        glfwPollEvents()
    }

    glfwTerminate()
}

fun testTextures()
{

    run {
        println("Creating tex1")

        memScoped {
            val tex1: GLuintVar = alloc()

            glGenTextures(1, tex1.ptr)
            glBindTexture(GL_TEXTURE_2D, tex1.value)

            assert(tex1.value == 1)
        }
    }

    run {
        println("Creating tex2")

        memScoped {
            val tex2: GLuintVar = alloc()

            glGenTextures(1, tex2.ptr)
            glBindTexture(GL_TEXTURE_2D, tex2.value)

            assert(tex2.value == 2)
        }
    }

}
