package jframe;

import com.sun.source.tree.SynchronizedTree;

import clientChat.gameClientReadMsg;
import clientChat.gameUserList;
import clientChat.scoreAll;
import music.Game;
import music.MusicPlayer;
import view.MainFrame;
import view.buttonsGUI.userNames;

public class ThreadExit {

	public ThreadExit() throws Exception {

		gameClientReadMsg.serverSongRandom.clear();

		MusicPlayer.runflag = false;

		// gameClientReadMsg.flag = false; 이걸 실행시 2번째 게임에서 게임 시작 안됨
		// 타이머 있으면 타이머도 끄기!!
		Game.interrupted();
		MusicPlayer.interrupted();
		// 메인버튼 클라스 쓰레드 임시 보류
		userNames.flag = false;
		MainFrame.introMusic.close();
		gameUserList.gameUserName.clear();
		scoreAll.userScore.clear();

		// gameClient.getSocket().close(); // 맨마지막으로 옮기기!
	}

}
