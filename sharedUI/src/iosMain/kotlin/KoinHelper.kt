import org.koin.core.Koin
import org.koin.core.context.startKoin
import org.koin.dsl.module
import ru.vlyashuk.drivekeep.cache.IOSDatabaseDriverFactory
import ru.vlyashuk.drivekeep.cache.DatabaseDriverFactory
import kotlin.experimental.ExperimentalObjCName

@OptIn(ExperimentalObjCName::class)
@ObjCName("KoinHelper")
object KoinHelper {
    lateinit var koin: Koin

}

fun initKoin() {
    KoinHelper.koin = startKoin {
        modules(module {
            single<DatabaseDriverFactory> { IOSDatabaseDriverFactory() }
        })
    }.koin
}
