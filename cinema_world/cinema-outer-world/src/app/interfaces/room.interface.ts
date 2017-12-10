export interface RoomDimension {
  row?: number;
  seatNumber?: number;
}

export interface Room {
  id?: number;
  name?: string;
  vip?: boolean;
  bedRoom?: boolean;
  imax?: boolean;
  threeDimensional?: boolean;
  fourDimensional?: boolean;
  row?: number;
  seatNumber?: number;
}
