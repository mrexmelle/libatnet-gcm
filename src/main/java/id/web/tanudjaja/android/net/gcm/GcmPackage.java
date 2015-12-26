
package id.web.tanudjaja.android.net.gcm;

import id.web.tanudjaja.android.common.port.errno;

public class GcmPackage
{
	private int mErrno;
	private String mId;
	
	public GcmPackage()
	{
		mErrno=errno.SUCCESS;
		mId=null;
	}
	
	public GcmPackage(int aErrno, String aId)
	{
		mErrno=aErrno;
		mId=aId;
	}

	public int getErrno() { return mErrno; }

	public String getId() { return mId; }
};

