
package id.web.tanudjaja.android.net.gcm;

import id.web.tanudjaja.android.common.port.errno;

import java.io.IOException;

import com.google.android.gms.gcm.GoogleCloudMessaging;

import android.content.Context;
import android.os.AsyncTask;

public class AsyncGcmRegistrationTask extends AsyncTask<Void, Double, GcmPackage>
{
	protected Context mContext;
	private final String mProjectNumber;
	protected AsyncGcmRegistrationTaskListener mListener;
	
	public AsyncGcmRegistrationTask(Context aContext, String aProjectNumber, AsyncGcmRegistrationTaskListener aListener)
	{
		mContext=aContext;
		mProjectNumber=aProjectNumber;
		mListener=aListener;
	}
	
	public AsyncGcmRegistrationTask(Context aContext, String aProjectNumber)
	{
		mContext=aContext;
		mProjectNumber=aProjectNumber;
		mListener=null;
	}
	
	public AsyncGcmRegistrationTask SetListener(AsyncGcmRegistrationTaskListener aListener)
	{
		mListener=aListener;
		return this;
	}
	
	
	@Override
	protected GcmPackage doInBackground(Void... params)
	{
		GoogleCloudMessaging gcm=GoogleCloudMessaging.getInstance(mContext);
		String regId;
		try
		{
			regId=gcm.register(mProjectNumber);
		}
		catch(IOException e)
		{
			return new GcmPackage(errno.EIO, null);
		}
		
		if(regId==null)
		{
			return new GcmPackage(errno.ENOMSG, null);
		}
		
		return new GcmPackage(errno.SUCCESS, regId);
	}
	
	@Override
	protected void onPostExecute(GcmPackage aGcmPckg)
	{
		if(mListener!=null){ mListener.onGcmIdRetrieved(this, aGcmPckg.getErrno(), aGcmPckg.getId()); }
	}
	
};
