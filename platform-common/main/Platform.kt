enum class PlatformType
{
    Windows, MacOs, Linux, IOs, Android, WebAssembly
}

expect object Platform
{
    val type: PlatformType
}

expect object System
{
    fun sleep(ms: Int)
}
