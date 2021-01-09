package me.sanchez.shared

import kotlin.coroutines.CoroutineContext

expect val ioDispatcher: CoroutineContext
expect val uiDispatcher: CoroutineContext