package com.example.sweater.modul;

public class UserTrainDTO {
    private User user;
    private Train train;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public UserTrainDTO(User user, Train train) {
        this.user = user;
        this.train = train;
    }
}
