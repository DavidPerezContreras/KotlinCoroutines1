#Kotlin Coroutines Example 1

Data layer example using withContext, runBlocking and suspend functions




#


runBlocking() and coroutineScope() are functionally very similar. They both pause the current execution waiting until the inner coroutine finishes. The difference is that runBlocking() is meant to be executed from a regular non-suspendable code, so it waits by blocking and coroutineScope() is used from suspendable context, so it suspends.

That difference makes them do much different things internally. runBlocking() has to first initialize the whole coroutines machinery before it could execute a suspendable lambda. coroutineScope() has access to existing coroutine context, so it only schedules the inner lambda to be executed and suspends.

Now, suspend fun main() is just a "shortcut" that Kotlin compiler provides to make it easier to initialize coroutines apps. Internally, it creates a bridge between the real main function and your suspendable main function. It generates a separate main() function, which is not suspendable and is the "real" main function. This function initializes a coroutine and uses internal runSuspend() utility to execute your suspend fun main(). This is described here: https://github.com/Kotlin/KEEP/blob/master/proposals/enhancing-main-convention.md#implementation-details-on-jvm-1

Both methods of starting a coroutine application are very similar and you can choose according to your taste. One notable difference is that runBlocking() creates a dispatcher using the current "main" thread. suspend fun main() also executes using the main thread, but it doesn't specify the dispatcher, so whenever you use e.g. coroutineScope() it will switch to Dispatchers.Default. As a result, your runBlocking() example uses single-threaded dispatcher while your coroutineScope() example uses multi-threaded Dispatchers.Default. However, this difference should not really be taken into account when choosing between both methods. We can very easily switch dispatchers at any time.







https://stackoverflow.com/questions/72066943/coroutines-main-runblocking-vs-suspend-main