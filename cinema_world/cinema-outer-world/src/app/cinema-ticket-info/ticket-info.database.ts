export interface TicketInfo {
  type: string;
  twoDimensionalPrice: number;
  imaxPrice: number;
  imaxGlassPrice: number;
  threeDimensionalPrice: number;
  threeDimensionalGlassPrice: number;
  fourDimensionalPrice: number;
  fourDimensionalGlassPrice: number;
  bedRoomPrice: number;
  bedRoomGlassPrice: number;
}

export class TicketInfoDatabase {
  private ticketInfoData: TicketInfo[] = [
    {type: "Gyerek",
    twoDimensionalPrice: 0,
    imaxPrice: 0,
    imaxGlassPrice: 0,
    threeDimensionalPrice: 0,
    threeDimensionalGlassPrice: 0,
    fourDimensionalPrice: 0,
    fourDimensionalGlassPrice: 0,
    bedRoomPrice: 0,
    bedRoomGlassPrice: 0},

    {type: "Felnőtt",
    twoDimensionalPrice: 0,
    imaxPrice: 0,
    imaxGlassPrice: 0,
    threeDimensionalPrice: 0,
    threeDimensionalGlassPrice: 0,
    fourDimensionalPrice: 0,
    fourDimensionalGlassPrice: 0,
    bedRoomPrice: 0,
    bedRoomGlassPrice: 0},
  ];

  getData(): TicketInfo[] {
    return this.ticketInfoData;
  }
}


