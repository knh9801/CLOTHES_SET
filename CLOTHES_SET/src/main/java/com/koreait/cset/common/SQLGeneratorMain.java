package com.koreait.cset.common;

import java.util.HashMap;
import java.util.Map;

public class SQLGeneratorMain {
public static void main(String[] args) {
		
		StringBuffer sb = new StringBuffer();
		
		// Reviews : 
		
		String sql1 = "INSERT INTO REVIEWS VALUES(REVIEWS_SEQ.NEXTVAL, ";
		
		String[] mId = new String[10];		
		for(int i=0; i<mId.length; i++) {
			mId[i] = "USER"+(i+1);
		}
		
		
		Map<Integer, String> rateContent = new HashMap<Integer, String>();
		rateContent.put(1, "꽤나 비싸게 샀다고 생각하는데.. 배송 늦는 건 말할것도 없고 옷도 한가운데가 찢어져서 왔어요");
		rateContent.put(2, "이 가격을 주고 살만한 제품은 아니라 생각해요... 너무 비쌈");
		rateContent.put(3, "그저 그런 옷입니다. 비싼데 생각보다 옷감도 그닥인거 같고.. 잘 모르겠네요");
		rateContent.put(4, "상당히 괜찮은 제품입니다. 다만 실제 색감이 사진과 달라요");
		rateContent.put(5, "이 가격에 이 옷을 사다니! 너무 좋아요! 옷감, 가격, 핏 모두 만족해요. 배송도 빨랐어요!");
		
		String[] rFilename = { null,"review1.jpg", "review2.jpg", "review3.jpg", "review4.jpg" };
		
		// 생성
		for(int i=0; i<170; i++) {
			for(int j=0; j<2; j++) {
				// PNO
				sb.append(sql1).append(i+1).append(", ");
				// MID
				sb.append("'").append(mId[(int)(Math.random())*10]).append("', ");				
				int rating = (int)(Math.random()*5) + 1;
				// RCONTENT
				sb.append("'").append(rateContent.get(rating)).append("', ");
				// RFILENAME
				sb.append("'").append( rFilename[ rating-1 ]).append("', ");
				// RREGDATE
				sb.append("SYSDATE, ");
				// RRATING
				sb.append(rating).append(");\n");
				
				System.out.println(sb.toString());
			}
		}
	}
}
