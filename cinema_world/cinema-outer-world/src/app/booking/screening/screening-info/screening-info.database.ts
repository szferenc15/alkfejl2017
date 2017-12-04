export interface ScreeningInfo {
  id: number,
  title: string,
  cinemaId: number,
  roomId: number,
  language: string,
  twoDimensional: boolean,
  threeDimensional: boolean,
  fourDimensional: boolean,
  imax: boolean,
  synchron: boolean,
  inscriptive: boolean,
  screenDay: Date,
  screenTime: string,
}

export class ScreeningInfoDatabase {
  private screeningInfoData: ScreeningInfo[] = [
    {
      id: 0,
      title: 'Thor: Ragnarok',
      cinemaId: 1,
      roomId: 1,
      language: 'magyar',
      twoDimensional: false,
      threeDimensional: true,
      fourDimensional: false,
      imax: true,
      synchron: true,
      inscriptive: false,
      screenDay: new Date(2017, 11, 20),
      screenTime: '21:00:00',
    },
    {
      id: 1,
      title: 'Star Wars: The Last Jedi',
      cinemaId: 2,
      roomId: 2,
      language: 'orosz',
      twoDimensional: false,
      threeDimensional: true,
      fourDimensional: false,
      imax: true,
      synchron: true,
      inscriptive: false,
      screenDay: new Date(2017, 12, 14),
      screenTime: '23:30:00',
    },
  ];

  getData(): ScreeningInfo[] {
    return this.screeningInfoData.slice();
  }
}


