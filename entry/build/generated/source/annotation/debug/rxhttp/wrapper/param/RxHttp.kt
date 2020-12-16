package rxhttp.wrapper.param

import kotlin.Unit
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import rxhttp.wrapper.entity.Progress
import rxhttp.wrapper.parse.SimpleParser

inline fun <reified T> RxHttp<*, *>.executeList() = executeClass<List<T>>()

inline fun <reified T> RxHttp<*, *>.executeClass() = execute(object : SimpleParser<T>() {})

inline fun <reified T> BaseRxHttp.asList() = asClass<List<T>>()

inline fun <reified K, reified V> BaseRxHttp.asMap() = asClass<Map<K,V>>()

inline fun <reified T> BaseRxHttp.asClass() = asParser(object : SimpleParser<T>() {})

/**
 * 调用此方法监听上传进度                                                    
 * @param coroutine  CoroutineScope对象，用于开启协程回调进度，进度回调所在线程取决于协程所在线程
 * @param progress 进度回调  
 */
fun <P : AbstractBodyParam<P>, R : RxHttpAbstractBodyParam<P, R>> RxHttpAbstractBodyParam<P,
    R>.upload(coroutine: CoroutineScope, progress: suspend (Progress) -> Unit): R {
  param.setProgressCallback {
      coroutine.launch { progress(it) }
  }
  return this as R
}
