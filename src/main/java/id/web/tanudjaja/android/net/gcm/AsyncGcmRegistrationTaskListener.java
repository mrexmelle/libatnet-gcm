
package id.web.tanudjaja.android.net.gcm;

import id.web.tanudjaja.android.common.port.errno;

public interface AsyncGcmRegistrationTaskListener
{
	public abstract void onGcmIdRetrieved(AsyncGcmRegistrationTask aTask, int aError, String aGcmId);
};
