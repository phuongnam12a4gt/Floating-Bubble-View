package com.torrydo.floatingbubbleview

import android.content.Intent
import android.os.IBinder
import com.torrydo.floatingbubbleview.utils.Constant
import com.torrydo.floatingbubbleview.utils.logger.ILogger
import com.torrydo.floatingbubbleview.utils.logger.Logger
import com.torrydo.floatingbubbleview.utils.toTag

abstract class FloatingBubbleService : FloatingBubbleConfig() {

    private lateinit var logger: ILogger

    override fun onCreate() {
        super.onCreate()
        logger = Logger().setTag(javaClass.simpleName.toTag()).setDebugEnabled(Constant.IS_DEBUG_ENABLED)
        logger.log("floating bubble service created")
    }

    override fun onDestroy() {
        super.onDestroy()
        logger.log("service destroyed")
    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        setup()

        return START_NOT_STICKY
    }

    open fun setDebugEnabled(debugEnabled: Boolean){
        Constant.IS_DEBUG_ENABLED = debugEnabled
    }


    override fun onBind(intent: Intent?): IBinder? = null



}