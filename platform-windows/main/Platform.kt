actual object Platform
{
    actual val type: PlatformType = PlatformType.Windows

}

actual object System
{
    actual fun sleep(ms: Int)
    {
        println("should sleep: $ms")
    }
}